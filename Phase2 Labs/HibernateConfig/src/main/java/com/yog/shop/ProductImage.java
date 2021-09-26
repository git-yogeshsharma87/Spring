package com.yog.shop;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product_image")
public class ProductImage {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int imageId;
	
	private String imageUrl;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
private Product product;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="productImage")
	private List<ProductImageMeta> imageMetas;

	
public ProductImage() {
		super();
	}



public String getImageUrl() {
	return imageUrl;
}



public ProductImage(String imageUrl, Product product) {
	super();
	this.imageUrl = imageUrl;
	this.product = product;
	
	imageMetas = new ArrayList<>();
}



public ProductImage(String imageUrl, List<ProductImageMeta> imageMetas) {
	super();
	this.imageUrl = imageUrl;
	this.imageMetas = imageMetas;
}



public List<ProductImageMeta> getImageMetas() {
	return imageMetas;
}


public ProductImage(String imageUrl) {
	super();
	this.imageUrl = imageUrl;
}



public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}



public int getImageId() {
	return imageId;
}



public void setProduct(Product product) {
	this.product = product;
}


public void addImageMeta(ProductImageMeta meta) {
	
	imageMetas.add(meta);
}


}
