const stripe = Stripe('pk_test_51OJrqCLVD5FyumV8QJzDzSTY2Gg4dzmgnj7mcUEc2TCdj3BX5TZ9k5PNlFwmQtVPtt6879bQ5MpksMOP9mV8RowQ004N4dH8T8');
 const paymentButton = document.querySelector('#paymentButton');
 
 paymentButton.addEventListener('click', () => {
   stripe.redirectToCheckout({
     sessionId: sessionId
   })
 });