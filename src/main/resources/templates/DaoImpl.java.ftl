<#assign basepackage = package.Service?replace(".service","")>
package ${basepackage}.dao.impl;

import ${basepackage}.common.db.dao.BaseDao;
import ${basepackage}.bean.${entity};
import ${basepackage}.dao.${entity}Dao;
import org.springframework.stereotype.Repository;

/**
* <p>
 * ${table.comment!}
 * </p>
*
* @author ${author}
* @since ${date}
*/
@Repository
public class ${entity}DaoImpl extends BaseDao<Integer, ${entity}> implements ${entity}Dao {

}

