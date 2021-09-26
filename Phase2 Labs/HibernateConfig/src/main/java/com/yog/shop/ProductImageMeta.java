package com.yog.shop;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product_image_meta")
public class ProductImageMeta {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int metaId;
	
	private String meta_Key;

	private String meta_Value;
	
	
	public ProductImageMeta(String meta_Key, String meta_Value, ProductImage productImage) {
		super();
		this.meta_Key = meta_Key;
		this.meta_Value = meta_Value;
		this.productImage = productImage;
	}


	@ManyToOne(fetch=FetchType.LAZY)
private ProductImage productImage;




	public ProductImageMeta() {
		super();
	}


	public int getMetaId() {
		return metaId;
	}


	public void setMetaId(int metaId) {
		this.metaId = metaId;
	}


	public String getMeta_Value() {
		return meta_Value;
	}


	public void setMeta_Value(String meta_Value) {
		this.meta_Value = meta_Value;
	}


	public ProductImage getProductImage() {
		return productImage;
	}


	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}


	public String getMeta_Key() {
		return meta_Key;
	}





}
