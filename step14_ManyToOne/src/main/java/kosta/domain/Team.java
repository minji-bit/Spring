package kosta.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@ToString( exclude = "memberList")
@Builder
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	
	@Column(nullable = false, length=100)
	private String teamName;
	/**
	 * cascade는  Entity 의 상태변화가 생기면 연관관계 있는
	 *  Entity도 상태변화를 전이시키는 옵션
	 *	CascadeType.ALL: 모든 CascadeType을 적용
	 *	CascadeType.PERSIST: 부모 엔티티를 저장할 때 연관된 자식 엔티티도 함께 저장
	 * 	CascadeType.MERGE: 부모 엔티티를 병합할 때 연관된 자식 엔티티도 함께 병합
	 * 	CascadeType.REMOVE: 부모 엔티티를 삭제할 때 연관된 자식 엔티티도 함께 삭제
	 * 	CascadeType.REFRESH: 부모 엔티티를 새로 고칠 때 연관된 자식 엔티티도 함께 새로 고침
	 * 	CascadeType.DETACH: 부모 엔티티를 분리할 때 연관된 자식 엔티티도 함께 분리
	 * */
	//@OneToMany(mappedBy = "team") // 지연로딩
	@OneToMany(mappedBy = "team",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE) 
	private List<Member> memberList;
}
