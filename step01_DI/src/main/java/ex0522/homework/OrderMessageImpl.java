package ex0522.homework;

public class OrderMessageImpl implements OrderMessage {
	private int orderId;
	private String message;
	private ProductBean proBean;
	private UserBean userBean;
	public OrderMessageImpl() {
	}
	
	
	public int getOrderId() {
		return orderId;
	}




	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}




	



	public ProductBean getProBean() {
		return proBean;
	}


	public void setProBean(ProductBean proBean) {
		this.proBean = proBean;
	}


	public UserBean getUserBean() {
		return userBean;
	}


	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}


	@Override
	public void getOrderMessage() {
		System.out.println("orderId :"+orderId);
		System.out.println("name :"+userBean.getName());
		System.out.println("phone :"+userBean.getPhone());
		System.out.println("상품명 :"+proBean.getPname());
		System.out.println("상품가격 :"+proBean.getPrice());
		System.out.println("메시지 :"+message);
	}

}
