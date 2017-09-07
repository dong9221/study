package dong.mybatis.domain;

public class Dept {
	private Integer id;
	private Integer num;
	private Integer pid;
	private String fullname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", num=" + num + ", pid=" + pid + ", fullname=" + fullname + "]";
	}
	
}
