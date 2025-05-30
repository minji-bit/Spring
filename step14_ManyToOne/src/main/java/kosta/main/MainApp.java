package kosta.main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.domain.Member;
import kosta.domain.Team;


public class MainApp {
	public static void main(String[] args) {
		System.out.println("********JPA 시작하기******");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		//Team등록
		/*Team t1 = Team.builder().teamName("team1").build();
		Team t2 = Team.builder().teamName("team2").build();
		Team t3 = Team.builder().teamName("team3").build();
		
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		
		//Member등록
		em.persist(Member.builder().name("민지").age(30).team(t1).build());
		em.persist(Member.builder().name("하하").age(24).team(t1).build());
		em.persist(Member.builder().name("나나").age(52).team(t1).build());
		
		em.persist(Member.builder().name("미미").age(24).team(t2).build());
		em.persist(Member.builder().name("영지").age(42).team(t2).build());
		
		em.persist(Member.builder().name("영식").age(24).team(t3).build());
		em.persist(Member.builder().name("다영").age(42).team(t3).build());*/
		
		//회원 검색해보자!!
		/*Member m =em.find(Member.class, 2L);
		System.out.println("m="+m);
		Team t =m.getTeam();
		System.out.println(t);*/
		
		////////////////////////////////////////////
		//team1 에 소속된 멤버정보를 team 정보와 함께 조회!!
		/*Team t = em.find(Team.class, 1L);
		System.out.println("team="+t);*/
		
		//삭제
		/*Member m = em.find(Member.class, 2L);
		em.remove(m);
		*/
		Team t = em.find(Team.class, 1L);
		em.remove(t);
		
		
		et.commit();
		em.close();
		emf.close();
	}
}
