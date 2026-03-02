function startPayment(amount, subCourseSortId, projectPath) {
	console.log("amount :", amount)
	console.log("subCourseSortId :", subCourseSortId)
    if (!amount || amount <= 0) {
        alert("Invalid amount. Please try again.");
        return;
    }

    $.ajax({
        url: projectPath + '/viewPages/user-view-pages/courses-view-pages/buyCourseStart',
        type: 'POST',
        data: JSON.stringify({
            amount: amount,
            subCourseSortId: subCourseSortId
        }),
        contentType: 'application/json',
        dataType: 'json',

        success: function (response) {
            if (response.status === "success") {

                let order = response.order;

                let options = {
                    key: "rzp_test_y6jclhTIafQZdK",
                    amount: order.amount,
                    currency: order.currency,
                    name: "EDUCATION25",
                    description: "Buy Courses",
                    /*image: projectPath + "/images/Screenshot.png",*/
                    order_id: order.id,

                    handler: function (paymentResponse) {

                        $.ajax({
                            url: projectPath + '/viewPages/user-view-pages/courses-view-pages/buyCourse/afterSuccesPamentBuyCourse',
                            type: 'POST',
                            data: JSON.stringify({
                                amount: amount,
                                subCourseSortId: subCourseSortId,
                                payment_id: paymentResponse.razorpay_payment_id,
                                order_id: paymentResponse.razorpay_order_id,
                                signature: paymentResponse.razorpay_signature
                            }),
                            contentType: 'application/json',
                            dataType: 'json',

                            success: function (response) {		
								alert(response.message)
                            },

                            error: function (response) {
								alert(response.message_error)
								console.log("tax2")
                            }
                        });
                    }
                };

                let rzp = new Razorpay(options);

                rzp.on('payment.failed', function (res) {
                    alert("Payment failed!");

                });

                rzp.open();

            } else{
				if(response.message_error!=null){
					alert(response.message_error);
					console.log("tax1")
					window.location.href = projectPath+'/index.jsp';
				}
            }
        },

        error: function (error) {
            alert("Server error. Please try again.");
        }
    });
}
