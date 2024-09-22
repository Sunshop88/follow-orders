package net.maku.followcom.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * 品种规格
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "品种规格")
public class FollowSysmbolSpecificationVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Schema(description = "账号id")
	private Long traderId;

	@Schema(description = "品种")
	private String symbol;

	@Schema(description = "品种类型")
	private String profitMode;

	@Schema(description = "最小手数")
	private Double minLot;

	@Schema(description = "最大手数")
	private Double maxLot;

	@Schema(description = "步长")
	private Double lotStep;

	@Schema(description = "买入库存费")
	private Double swapLong;

	@Schema(description = "卖出库存费")
	private Double swapShort;

	@Schema(description = "合约大小")
	private Double contractSize;

	@Schema(description = "小数位")
	private Integer digits;

	@Schema(description = "预付款货币")
	private String marginCurrency;

	@Schema(description = "版本号")
	private Integer version;

	@Schema(description = "删除标识 0：正常 1：已删除")
	private Integer deleted;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新者")
	private Long updater;

	@Schema(description = "更新时间")
	private Date updateTime;

}