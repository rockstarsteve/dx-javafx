package com.dx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/9/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataRecord {
    private String id;
    private String name;
    private String alias;
}
