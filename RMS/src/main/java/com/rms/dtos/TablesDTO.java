package com.rms.dtos;

public class TablesDTO {
	private int tableId;
	private String tableName;
	private int tableCapacity;
	private int waiterId;
	private String waiterName;
	private String tableStatus = "Not Booked";
	public TablesDTO(int tableId, String tableName, int tableCapacity, int waiterId, String waiterName,
			String tableStatus) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.waiterId = waiterId;
		this.waiterName = waiterName;
		this.tableStatus = tableStatus;
	}
	
	public TablesDTO(int tableId, String tableName, int tableCapacity, int waiterId, String tableStatus) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.waiterId = waiterId;
		this.tableStatus = tableStatus;
	}

	public TablesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TablesDTO [tableId=" + tableId + ", tableName=" + tableName + ", tableCapacity=" + tableCapacity
				+ ", waiterId=" + waiterId + ", waiterName=" + waiterName + ", tableStatus=" + tableStatus + "]";
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getTableCapacity() {
		return tableCapacity;
	}
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}
	public int getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}
	public String getWaiterName() {
		return waiterName;
	}
	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}
	public String getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}
	
	
}
