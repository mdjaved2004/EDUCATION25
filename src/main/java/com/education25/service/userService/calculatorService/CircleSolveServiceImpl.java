package com.education25.service.userService.calculatorService;

public class CircleSolveServiceImpl implements CircleSolveService{
	private double clculate_value=0;
	
	@Override
	public String[] circleSolveService(String operator, float circle_redious) {
		String result_number_string=null, result_text=null;
		double result=0;
		String resultArray[] =new String[2];
		
		switch (operator) {
	    case "a":
	        result = areaOfCircle(circle_redious);
	        result_number_string = result + "";
	        result_text = "Area of the circle";
	        break;

	    case "d":
	        result = diameterOfCircle(circle_redious);
	        result_number_string = result + "";
	        result_text = "Diameter of the circle";
	        break;

	    case "c":
	        result = circumfarenceOfCircle(circle_redious);
	        result_number_string = result + "";
	        result_text = "Circumference of the circle";
	        break;

	    case "s":
	        result = semicircleOfCircle(circle_redious);
	        result_number_string = result + "";
	        result_text = "Area of the Semicircle";
	        break;

	    case "all_r":
	        result = areaOfCircle(circle_redious);
	        result_number_string = "Area = " + result;

	        result = diameterOfCircle(circle_redious);
	        result_number_string += " Diameter = " + result + "<br>";

	        result = circumfarenceOfCircle(circle_redious);
	        result_number_string += " Circumference = " + result;

	        result = semicircleOfCircle(circle_redious);
	        result_number_string += " Semicircle = " + result;

	        result_text = null;
	        break;

	    default:
	        result_number_string = "Invalid operator";
	        result_text = null;
	}
		resultArray[0]=result_number_string;
		resultArray[1]=result_text;

		return resultArray;
	}
	
	public double math_round(double value) {
		return Math.round(value* 100.00) / 100.00;	
	}
	
	//calculate circle operators
	public  double areaOfCircle(float circle_redious) {
		clculate_value=3.142857*circle_redious*circle_redious;	 
		return math_round(clculate_value);
	}
	public double diameterOfCircle(float circle_redious) {
		clculate_value=2*circle_redious;	 
		return math_round(clculate_value);
	}
	public double circumfarenceOfCircle(float circle_redious) {
		clculate_value=2*3.142857*circle_redious;	 
		return math_round(clculate_value);	
	}
	public double semicircleOfCircle(float circle_redious) {	
		clculate_value=(3.142857*circle_redious*circle_redious)/2;	 
		return math_round(clculate_value);
	}
}