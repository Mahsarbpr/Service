package com.coupon;
import java.util.Date;

public class Coupon {
public int CouponID;
public int Discount;
int CouponType; //There should be better option for defining Coupon Type
Date ValidTime1 = new Date();
Date ValidTime2 = new Date();
public int getCouponID() {
	return CouponID;
}
public void setCouponID(int couponID) {
	CouponID = couponID;
}
public int getDiscount() {
	return Discount;
}
public void setDiscount(int discount) {
	Discount = discount;
}
public int getCouponType() {
	return CouponType;
}
public void setCouponType(int couponType) {
	CouponType = couponType;
}
public Date getValidTime1() {
	return ValidTime1;
}
public void setValidTime1(Date validTime1) {
	ValidTime1 = validTime1;
}
public Date getValidTime2() {
	return ValidTime2;
}
public void setValidTime2(Date validTime2) {
	ValidTime2 = validTime2;
}

}
