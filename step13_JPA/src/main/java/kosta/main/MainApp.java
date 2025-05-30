package kosta.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.domain.Customer;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("********JPA 시작하기******");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		// 작업
		/*
		 * em.persist(Customer.builder().userName("민지").age(30).birthDay(new
		 * Date()).build());
		 * em.persist(Customer.builder().userName("용용").age(10).birthDay(new
		 * Date()).build());
		 * em.persist(Customer.builder().userName("하하").age(100).birthDay(new
		 * Date()).build());
		 * em.persist(Customer.builder().userName("낄낄").age(80).birthDay(new
		 * Date()).build());
		 */
		// em.persist(Customer.builder().userName("아아").birthDay(new Date()).build());

		// em.persist(Employee.builder().name("민지").build());
		// 레코드 추가

		// 조회 = 검색
		/*
		 * Customer cu = em.find(Customer.class, 3L); System.out.println("cu="+cu);
		 * Customer cu2 = em.find(Customer.class, 3L); System.out.println("cu2="+cu2);
		 * 
		 * //수정 //cu.setAge(70); //cu.setUserName("가지");
		 */

		// 삭제
//		Employee e = em.find(Employee.class, 2L);
//		em.remove(e);

		////////////////////////////////////

		/**
		 * 다양한 조건의 쿼리를 작성하고 싶다. - 직접 쿼리를 작성해야 한다. JPQL 문법을 이용해서 Entity 즉 객체 중심으로 쿼리를 작성할
		 * 수 있다. 이것은 특정 DB에 종속적이지 않다는 것이 장점
		 */
		/**
		 * 1.나이가 25살 이상인 정보를 검색하고 싶다.
		 */
//		String sql = "select c from Customer c where c.age >= 25";
		/*
		 * String sql = "select c from Customer c where c.userName like '%가%'";
		 * List<Customer> list =em.createQuery(sql,Customer.class).getResultList();
		 * 
		 * for (Customer cu : list) { System.out.println("cu = "+cu); }
		 */

		////////////////////////////////////

		// 인수=parameter를 전달해서 조건으로 사용하고 싶다.
		/*
		 * String sql =
		 * "select c from Customer c where c.age >= ?1 or c.userName like ?2";
		 * List<Customer> list =em.createQuery(sql,Customer.class) .setParameter(1, 25)
		 * .setParameter(2, "%가%").getResultList(); for (Customer cu : list) {
		 * System.out.println("cu = "+cu); }
		 */

		String sql = "select c from Customer c where c.age >= :age or c.userName like :name";
		List<Customer> list = em.createQuery(sql, Customer.class)
								.setParameter("age", 25)
								.setParameter("name", "%가%")
								.getResultList();
		for (Customer cu : list) {
			System.out.println("cu = " + cu);
		}
		et.commit();
		em.close();
		emf.close();
	}
}
