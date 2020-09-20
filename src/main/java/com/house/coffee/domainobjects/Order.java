package com.house.coffee.domainobjects;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@ToString
@Data
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(name = "customerid")
	private String customerId;

	private String status;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> itemList;

	@Column(name = "createddate")
	private Date createdDate;

	@Column(name = "updateddate")
	private Date updatedDate;
}
