package jsfbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class JsfNumerosBean {
	private int num;
	
	public JsfNumerosBean() {
		
	}

	public JsfNumerosBean(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public void mostrarnum(){
		System.out.println(num);
	}
	
	
	
}
