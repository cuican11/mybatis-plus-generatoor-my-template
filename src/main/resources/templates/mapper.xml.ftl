<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#assign basepackage = package.Service?replace(".service","")>
<#macro el1 value>${r"#{"}${value}}</#macro>

<mapper namespace="${basepackage}.dao.impl.${entity}DaoImpl">

    <#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>
</#if>
<#if baseResultMap>
<!-- 通用查询映射结果 -->
<resultMap id="BaseResultMap" type="${basepackage}.bean.${entity}">
    <#list table.fields as field>
    <#if field.keyFlag><#--生成主键排在第22一位-->
    <id column="${field.name}" property="${field.propertyName}" jdbcType="${field.type}"/>
</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
<result column="${field.name}" property="${field.propertyName}" jdbcType="${field.type}"/>
</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
<result column="${field.name}" property="${field.propertyName}" jdbcType="${field.type}"/>
</#if>
</#list>
</resultMap>

</#if>
<#if baseColumnList>
<!-- 通用查询结果列 -->
<sql id="Base_Column_List">
    <#list table.commonFields as field>
    ${field.name},
</#list>
${table.fieldNames}
</sql>
</#if>

<select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Integer" >
    select
    <include refid="Base_Column_List" />
    from ${table.name}
    where
    <#list table.commonFields as field>
        ${field.name} = <@el1 field.name />
    </#list>
<#list table.fields as field>
<#if field.name = 'del_flag'>
  and del_flag = 0
</#if>
</#list>
</select>

<insert id="insert" parameterType="${basepackage}.bean.${entity}" useGeneratedKeys="true" keyProperty="id">
    insert into ${table.name} (<include refid="Base_Column_List" />
    )
    values ( null,
    <#list table.fields as field>
    <#if field.name='create_time'>
    now(),<!--生成日期  -->
    <#else>
    <@el1 field.name/>,
</#if>
</#list>
)
</insert>


<insert id="insertSelective" parameterType="${basepackage}.bean.${entity}" useGeneratedKeys="true" keyProperty="id">
    insert into ${table.name}
    <trim prefix="(" suffix=")" suffixOverrides="," >
        <#list table.fields as column>
        <if test=" ${column.name} != null" >
            ${column.name},
        </if>
    </#list>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
        <#list  table.fields as column>
        <if test=" ${column.name} != null" >
            <@el1 column.name/>,
        </if>
    </#list>
    </trim>
</insert>

<delete id="deleteByPrimaryKey" parameterType="id" >
    delete from ${table.name}
    where
    <#list table.commonFields as field>
        ${field.name} = <@el1 field.name />
    </#list>
</delete>

<update id="updateByPrimaryKeySelective" parameterType="${basepackage}.bean.${entity}" >
    UPDATE ${table.name}
    <set>
        <#list table.fields as column>
        <#if column.name !='update_time'>
        <if test="${column.name}!=null">
            ${column.name} = <@el1 column.name/>,
        </if>
    </#if>
</#list>
</set>
WHERE
<#list table.commonFields as column>
${column.name} = <@el1 column.name/>
</#list>

</update>


<!--查询条件-->
<sql id="selectCondition">
    <where>
        <trim suffixOverrides="and">

          <if test=" entity != null">
            <if test="entity.id!=null">
              and id=${r"#{entity.id}"}
            </if>
          </if>

            <#list table.fields as column>
            <#if column.name = 'del_flag'>
            and del_flag = 0
        </#if>
    </#list>
    </trim>
    <trim suffixOverrides="and">
        <if test="whereSql!=null">
            and ${r"${whereSql}"}
        </if>
    </trim>
    </where>
</sql>

<!-- 根据条件查询 -->
<select id="getListByEntityAndPageInfo" resultMap="BaseResultMap">
    select
    <include refid="Base_Column_List" />
    from ${table.name}
    <include refid="selectCondition" />
    <if test="orderBy!=null">
        ${r"${orderBy}"}
    </if>
    <if test="pageInfo!=null">
        limit ${r"${pageInfo.size}"} offset ${r"${pageInfo.startIndex}"}
    </if>
</select>

<!-- 查询总数 -->
<select id="getTotalByEntity" resultType="java.lang.Integer">
    select count(*) from ${table.name}
    <include refid="selectCondition" />
</select>

</mapper>