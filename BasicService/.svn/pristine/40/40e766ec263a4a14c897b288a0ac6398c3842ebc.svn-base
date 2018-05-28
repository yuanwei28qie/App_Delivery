/**
 * 
 */
package com.microsilver.mrcard.basicservice.dto;

import java.util.List;

import lombok.Data;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.dto.PageBeanDto
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年4月10日 下午1:56:22
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Data
public class PageBeanDto<T> {
	 	// 当前页
	     private Integer currentPage = 1;
	     // 每页显示的总条数
	     private Integer pageSize = 10;
	     // 总条数
	     private Integer totalNum;
	    // 是否有下一页
	     private Integer isMore;
	     // 总页数
	     private Integer totalPage;
	     // 开始索引
	     private Integer startIndex;
	     // 分页结果
	     private List<T> items;
		public PageBeanDto(Integer currentPage, Integer pageSize, Integer totalNum, Integer isMore, Integer totalPage,
				Integer startIndex, List<T> items) {
			super();
			this.currentPage = currentPage;
			this.pageSize = pageSize;
			this.totalNum = totalNum;
			this.isMore = isMore;
			this.totalPage = totalPage;
			this.startIndex = startIndex;
			this.items = items;
		}
		
		public PageBeanDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PageBeanDto(Integer currentPage, Integer pageSize, Integer totalNum) {
			super();
			this.currentPage = currentPage;
			this.pageSize = pageSize;
			this.totalNum = totalNum;
		}
	     
}
