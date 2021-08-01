package com.example.milkorder_backend.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class OrderDTO {

    @NotBlank(message = "所选店铺不能为空")
    @Size(min = 2, max = 30, message = "2到30位")
    private String store;  // 所选店铺

    @Size(min = 11, max = 11, message = "号码为11位")
    private String mobile;  // 下单者联系电话

    @NotBlank(message = "所购奶茶不能为空")
    @Size(min = 2, max = 15, message = "2到15位")
    private String drinkName;  // 所购奶茶

    @Size(min = 0, max = 50, message = "0到50位")
    private String tipDes;  // 加料描述

    @Size(min = 0, max = 50, message = "0到50位")
    private String otherDes;  // 其他描述

    private int drinkNum ; // 奶茶倍数

    private boolean isTakeOut ; // 是否外卖

}
