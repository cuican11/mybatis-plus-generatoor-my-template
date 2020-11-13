<#assign basepackage = package.Service?replace(".service","")>
package ${basepackage}.service.impl;

import ${basepackage}.common.db.domain.PageInfo;
import ${basepackage}.common.db.domain.PageControl;
import ${basepackage}.bean.${entity};
import ${basepackage}.service.${entity}Service;
import ${basepackage}.dao.${entity}Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* <p>
 * ${table.comment!} 服务实现类
 * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ${entity}ServiceImpl implements ${entity}Service {

@Autowired
private ${entity}Dao ${table.name}Dao;

public Integer insert${entity}(${entity} ${table.name}){
if (${table.name} == null) {
return 0;
}

Integer i = ${table.name}Dao.insert(${table.name});
return i;
}

public ${entity} find(Integer id){
return ${table.name}Dao.getEntityById(id);
}

public Integer deleteLogical(Integer id){
   ${entity} temp = new ${entity}();
   temp.setId(id);
   temp.setDelFlag(1);
   return ${table.name}Dao.update(temp);
}

public Integer update${entity}(${entity} ${table.name}){
if (${table.name} == null) {
return 0;
}

Integer i = ${table.name}Dao.update(${table.name});
return i;
}

public PageControl<${entity}> pageAndSortById(${entity} ${table.name}, PageInfo pageInfo){
return ${table.name}Dao.getPageByObject(${table.name}, pageInfo, null, " order by id asc ");
}

public PageControl<${entity}> page(${entity} ${table.name}, PageInfo pageInfo, String whereSql, String orderSql){
return ${table.name}Dao.getPageByObject(${table.name}, pageInfo, whereSql, orderSql);
}


}
