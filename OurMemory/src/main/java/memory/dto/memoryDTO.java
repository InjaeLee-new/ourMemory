package memory.dto;

public class memoryDTO {
	private int memory_num;
	private String memory_name;
	private String memory_pass;
	private String memory_subject;
	private String memory_content;
	private int memory_rec;
	private int memory_nrec;
	private int memory_hit;
	public int getMemory_rec() {
		return memory_rec;
	}
	public void setMemory_rec(int memory_rec) {
		this.memory_rec = memory_rec;
	}
	public int getMemory_nrec() {
		return memory_nrec;
	}
	public void setMemory_nrec(int memory_nrec) {
		this.memory_nrec = memory_nrec;
	}
	private String memory_file;
	private String memory_date;
	
	public int getMemory_num() {
		return memory_num;
	}
	public void setMemory_num(int memory_num) {
		this.memory_num = memory_num;
	}
	public String getMemory_name() {
		return memory_name;
	}
	public void setMemory_name(String memory_name) {
		this.memory_name = memory_name;
	}
	public String getMemory_pass() {
		return memory_pass;
	}
	public void setMemory_pass(String memory_pass) {
		this.memory_pass = memory_pass;
	}
	public String getMemory_subject() {
		return memory_subject;
	}
	public void setMemory_subject(String memory_subject) {
		this.memory_subject = memory_subject;
	}
	public String getMemory_content() {
		return memory_content;
	}
	public void setMemory_content(String memory_content) {
		this.memory_content = memory_content;
	}
	public String getMemory_file() {
		return memory_file;
	}
	public void setMemory_file(String memory_file) {
		this.memory_file = memory_file;
	}
	public String getMemory_date() {
		return memory_date;
	}
	public void setMemory_date(String memory_date) {
		this.memory_date = memory_date;
	}
	public int getMemory_hit() {
		return memory_hit;
	}
	public void setMemory_hit(int memory_hit) {
		this.memory_hit = memory_hit;
	}
	
	
}
