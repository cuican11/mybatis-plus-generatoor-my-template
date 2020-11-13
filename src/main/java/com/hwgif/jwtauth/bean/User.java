package com.hwgif.jwtauth.bean;

import com.hwgif.jwtauth.common.db.bean.BaseEntity;
import lombok.Data;
import java.time.LocalDateTime;
/**
 * <p>
 * 
 * </p>
 *
 * @author lc.huang
 * @since 2020-11-07
 */
@Data
public class User  extends BaseEntity {


    private static final long serialVersionUID = 1L;

    private Integer id;

    private String acount;

    /**
     * 姓名
     */
    private String userName;

    private String password;

    private String salt;

    private LocalDateTime createTime;

    private Integer delFlag;

    private LocalDateTime delTime;


}
