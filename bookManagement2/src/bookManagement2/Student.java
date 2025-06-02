package bookManagement2;

public class Student {
    
	private int s_id;
	private String s_name;
	private long w_no;
	
	public Student() {
	
		this.s_id = 0;
		this.s_name = null;
		this.w_no = 0;
	}
	
	
	
	public Student(int s_id, String s_name, long w_no) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.w_no = w_no;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public long getW_no() {
		return w_no;
	}

	public void setW_no(long w_no) {
		this.w_no = w_no;
	}

}
