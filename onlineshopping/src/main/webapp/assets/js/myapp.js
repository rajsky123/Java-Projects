$(function(){
	//Solving active menu problem
	
	switch(menu){
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if(menu=='Home')break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
});