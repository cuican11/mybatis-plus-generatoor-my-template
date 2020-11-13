<#assign basepackage = package.Service?replace(".service","")>
package ${basepackage}.dao;

import ${basepackage}.common.db.dao.IDao;
import ${basepackage}.bean.${entity};

/**
* <p>
 * ${table.comment!} dao 接口
 * </p>
*
* @author ${author}
* @since ${date}
*/
public interface ${entity}Dao extends IDao<Integer, ${entity}> {

}
