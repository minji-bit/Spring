package kosta.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString  // 이걸 쓰면 team 도 출력하기 위해서 team 도 select 쿼리 날린다.
@ToString//(exclude = "team")
@Builder
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	private String name;
	private int age;
	/**
	 * 연관관계
	 * @ManyToOne
	 * @OneToMany
	 * @OneToOne
	 */
	@ManyToOne // 즉시 로딩 (무조건 조인)
//	@ManyToOne(fetch = FetchType.LAZY) //지연 로딩
	@JoinColumn(name = "tid")
	private Team team;
	
}
