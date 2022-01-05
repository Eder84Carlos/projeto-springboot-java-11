package com.ederweb.eder.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ederweb.eder.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order") //anotação para não ter conflito com o nome da tabela padrão Order no banco de dados
public class Order implements Serializable {
	private static final long serialVersionUID = 1L; //Id padrão
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //as anotações para informar que é uma tabela no banco de dados 
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment; //essa anotação e para formata o instante do pedido
	
	private Integer orderStatus;
	
	@ManyToOne //muitos para 1 para gerar a chave estrangeira
	@JoinColumn(name = "client_id")   // nome da chave estrangeira 
	private User client; //associação um pedido tem um cliente
	
	@OneToMany(mappedBy = "id.order") //associação um para muitos
	private Set<OrderItem> items = new HashSet<>();
	
	public Order() {
	}

	public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus); //atribuir um OrderStatus ao objeto
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus); //pegando o valor inteiro da classe e transfomando em OrderStatus
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {     //caso em uma manutenção informe um null
			this.orderStatus = orderStatus.getCode(); //recebendo um OrderStatus e guardando internamnete inteiro
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItem> getItems(){
		return items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
