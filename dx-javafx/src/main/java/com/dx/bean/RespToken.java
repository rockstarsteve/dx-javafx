package com.dx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespToken implements Serializable {

    public String token;

}
