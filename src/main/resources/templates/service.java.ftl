<#assign basepackage = package.Service?replace(".service","")>
package ${basepackage}.service;

import ${basepackage}.common.db.domain.PageInfo;
import ${basepackage}.common.db.domain.PageControl;
import ${basepackage}.bean.${entity};


/**
* <p>
 * ${table.comment!} 服务类
 * </p>
*
* @author ${author}
* @since ${date}
*/
public interface ${entity}Service {

Integer insert${entity}(${entity} var);

${entity} find(Integer id);

Integer deleteLogical(Integer id);

Integer update${entity}(${entity} var);

PageControl<${entity}> page(${entity} var1, PageInfo pageInfo, String whereSql, String orderSql);

}