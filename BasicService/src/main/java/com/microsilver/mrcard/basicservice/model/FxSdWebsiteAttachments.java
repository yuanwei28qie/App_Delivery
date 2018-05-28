package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

@Data
public class FxSdWebsiteAttachments {
    private Integer id;

    private String path;

    private String url;

    private String md5;

    private String sha1;

    private Byte status;

    private Integer createTime;


}