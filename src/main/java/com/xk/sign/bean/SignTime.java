package com.xk.sign.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class SignTime {

    @Schema(name = "id", description = "Id", example = "1")
    private Integer id;

    @Schema(name = "monday", description = "星期一", example = "0.0")
    private Float monday;

    @Schema(name = "tuesday", description = "星期二", example = "0.0")
    private Float tuesday;

    @Schema(name = "wednesday", description = "星期三", example = "0.0")
    private Float wednesday;

    @Schema(name = "thursday", description = "星期四", example = "0.0")
    private Float thursday;

    @Schema(name = "friday", description = "星期五", example = "0.0")
    private Float friday;

    @Schema(name = "saturday", description = "星期六", example = "0.0")
    private Float saturday;

    @Schema(name = "sunday", description = "星期日", example = "0.0")
    private Float sunday;

    @Schema(name = "indexTime", description = "暂存时间", example = "1231231358")
    private Long indexTime;

    @Schema(name = "weekly", description = "当前周", example = "1")
    private Integer weekly;

    @Schema(name = "timeWeekTotal", description = "当前周签到总时长", example = "0.0")
    private Float timeWeekTotal;

    @Schema(name = "userInfo", description = "用户信息")
    private UserInfo userInfo;

    @Schema(name = "user", description = "用户")
    private User user;

}
