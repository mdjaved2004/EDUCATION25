package com.education25.service.userService.calculatorService;

public class QuadrilateralSolveServiceImpl implements QuadrilateralSolveService {

	private double clculate_value=0;
	
	@Override
	public String[] quadrilateralSolveService(float width, float length, String operator) {
		String result_number_string=null, result_text=null;
		double result=0;
		String resultArray[] =new String[2];
		
		switch (operator) {
		    case "a":
		        result = areaOfQuadrilateral(width, length);
		        result_number_string = String.valueOf(result);
		        result_text = "Area of the quadrilateral";
		        break;
	
		    case "p":
		        result = perimeterOfQuadrilateral(width, length);
		        result_number_string = String.valueOf(result);
		        result_text = "Perimeter of the quadrilateral";
		        break;
	
		    case "d":
		        result = diagonalOfQuadrilateral(width, length);
		        result_number_string = String.valueOf(result);
		        result_text = "Diagonal of the quadrilateral";
		        break;
	
		    case "all_r":
		        StringBuilder sb = new StringBuilder();
		        sb.append("Area = ").append(areaOfQuadrilateral(width, length))
		          .append(" Perimeter = ").append(perimeterOfQuadrilateral(width, length))
		          .append("<br>Diagonal = ").append(diagonalOfQuadrilateral(width, length));
	
		        result_number_string = sb.toString();
		        result_text = null;
		        break;
	
		    default:
		        result_number_string = "Invalid operator";
		        result_text = null;
		        break;
		}
		
		resultArray[0]=result_number_string;
		resultArray[1]=result_text;
		
		return resultArray;
	}
	
	public double math_round(double value) {
		return Math.round(value* 100.00) / 100.00;	
	}
	
	//calculate quardrilateral operators
	public double areaOfQuadrilateral(float width,float length) {
		clculate_value=width*length;	 
		return math_round(clculate_value);
	}
	public double perimeterOfQuadrilateral(float width,float length) {
		clculate_value=2*(length+width);	 
		return math_round(clculate_value);	
	}
	public double diagonalOfQuadrilateral(float width,float length) {
		clculate_value=(length*length)+(width*width);	 
		return math_round(clculate_value);	
	}
}