package com.xinyi.model;


public class deliveryCharge {
		
		//颜色规格
		private String colorRule;	
		private int thirty_six ;//三十六
		private int thirty_seven ;//三十七
		private int thirty_eight;//三十八
		private int thirty_nine ;//三十九
		private int forty;//四十
		private int forty_one;//四十一
		private int forty_two ;//四十二
		private int forty_three;//四十三
		private int forty_four;//四十四
		private int forty_five;//四十五
		private int forty_six;//四十六
		
		
		
		public deliveryCharge(String colorRule, int thirty_six, int thirty_seven, int thirty_eight, int thirty_nine,
				int forty, int forty_one, int forty_two, int forty_three, int forty_four, int forty_five,
				int forty_six) {
			super();
			this.colorRule = colorRule;
			this.thirty_six = thirty_six;
			this.thirty_seven = thirty_seven;
			this.thirty_eight = thirty_eight;
			this.thirty_nine = thirty_nine;
			this.forty = forty;
			this.forty_one = forty_one;
			this.forty_two = forty_two;
			this.forty_three = forty_three;
			this.forty_four = forty_four;
			this.forty_five = forty_five;
			this.forty_six = forty_six;
		}
		public String getColorRule() {
			return colorRule;
		}
		public void setColorRule(String colorRule) {
			this.colorRule = colorRule;
		}

		
		public int getThirty_six() {
			return thirty_six;
		}
		public void setThirty_six(int thirty_six) {
			this.thirty_six = thirty_six;
		}
		public int getThirty_seven() {
			return thirty_seven;
		}
		public void setThirty_seven(int thirty_seven) {
			this.thirty_seven = thirty_seven;
		}
		public int getThirty_eight() {
			return thirty_eight;
		}
		public void setThirty_eight(int thirty_eight) {
			this.thirty_eight = thirty_eight;
		}
		public int getThirty_nine() {
			return thirty_nine;
		}
		public void setThirty_nine(int thirty_nine) {
			this.thirty_nine = thirty_nine;
		}
		public int getForty() {
			return forty;
		}
		public void setForty(int forty) {
			this.forty = forty;
		}
		public int getForty_one() {
			return forty_one;
		}
		public void setForty_one(int forty_one) {
			this.forty_one = forty_one;
		}
		public int getForty_two() {
			return forty_two;
		}
		public void setForty_two(int forty_two) {
			this.forty_two = forty_two;
		}
		public int getForty_three() {
			return forty_three;
		}
		public void setForty_three(int forty_three) {
			this.forty_three = forty_three;
		}
		public int getForty_four() {
			return forty_four;
		}
		public void setForty_four(int forty_four) {
			this.forty_four = forty_four;
		}
		public int getForty_five() {
			return forty_five;
		}
		public void setForty_five(int forty_five) {
			this.forty_five = forty_five;
		}
		public int getForty_six() {
			return forty_six;
		}
		public void setForty_six(int forty_six) {
			this.forty_six = forty_six;
		}
		public deliveryCharge() {
			super();
			this.colorRule = "请输入颜色/规格";

		}
		public static void main(String[] args) {
			deliveryCharge deliveryCharge = new deliveryCharge();
			System.out.println(deliveryCharge);
		}
		@Override
		public String toString() {
			return "deliveryCharge [colorRule=" + colorRule + ", thirty_six=" + thirty_six + ", thirty_seven="
					+ thirty_seven + ", thirty_eight=" + thirty_eight + ", thirty_nine=" + thirty_nine + ", forty="
					+ forty + ", forty_one=" + forty_one + ", forty_two=" + forty_two + ", forty_three=" + forty_three
					+ ", forty_four=" + forty_four + ", forty_five=" + forty_five + ", forty_six=" + forty_six + "]";
		}
}
