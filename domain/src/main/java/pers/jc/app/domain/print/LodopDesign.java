package pers.jc.app.domain.print;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import priv.jc.app.core.domain.Domain;
import priv.jc.app.core.domain.system.User;

@Entity
@Table(name = "tr_lodop_design", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "tr_lodop_id", "tm_user_id" }) })
public class LodopDesign extends Domain {
	private static final long serialVersionUID = 6862687306564507005L;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tr_lodop_id", nullable = false, referencedColumnName = "id")
	private Lodop lodop;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tm_user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "context", nullable = false, columnDefinition = "nvarchar2(2000)")
	private String context;
}
