public abstract class MovieWithPrice {	 
	 public void showPrice() {
		 getPrice().getCharge();
     }	 
	 
	 public abstract Price getPrice();
	 public abstract void setPrice(Price price);
}

class ConMovieWithPrice1 extends MovieWithPrice {
	 private Price price;
	 
	 public ConMovieWithPrice1() {
	 }
	 
	 public ConMovieWithPrice1(Price price) {
		 this.price = price;
	 }
	 
	 public Price getPrice() {
		 return price;
	 }
	 
	 public void setPrice(Price price) {
		 this.price = price;
	 }
}

class ConMovieWithPrice2 extends MovieWithPrice {
	 private Price price;
	 
	 public ConMovieWithPrice2() {
	 }
	 
	 public ConMovieWithPrice2(Price price) {
		 this.price = price;
	 }
	 
	 public Price getPrice() {
		 return price;
	 }
	 
	 public void setPrice(Price price) {
		 this.price = price;
	 }
}

class ConMovieWithPrice3 extends MovieWithPrice {
	 private Price price;
	 
	 public ConMovieWithPrice3() {
	 }
	 
	 public ConMovieWithPrice3(Price price) {
		 this.price = price;
	 }
	 
	 public Price getPrice() {
		 return price;
	 }
	 
	 public void setPrice(Price price) {
		 this.price = price;
	 }
}