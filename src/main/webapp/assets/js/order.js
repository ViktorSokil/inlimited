
$(document).ready(function() {
    var productIds = getIdsFromBasket();
    var products = [];

    var tid = setInterval(addProductsToOrderForm, 1000);

    if (productIds){
        $.each(productIds, function (index, id) {
            $.ajax({
                url: "http://localhost:8081/products/"+id
            }).done(function(product) {
                products.push(product);
            }).fail(function ( jqXHR, textStatus, errorThrown) {
                console.log("Error: " + errorThrown)
            });
        });
    }

    function addProductsToOrderForm() {
        var length1 = productIds.length;
        var length2 = products.length;
        if (length1 == length2){
            abortTimer();
            var listAsString = buildListOfProducts(products);
            $(listAsString).appendTo(".products-list");
        }
    }
    function abortTimer() { // to be called when you want to stop the timer
        clearInterval(tid);
    }

    $("#order-btn").click(function (e) {
        e.preventDefault();
        userName = $("#recipient-name").val();
        userEmail = $("#recipient-email").val();
        if(!userName || !userEmail){
            return;
        }

        var order = buildOrder(products);
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'url': "http://localhost:8081/receipts",
            'data': JSON.stringify(order),
            'dataType': "text"
        }).done(function(data) {
            $("<p>Your products successfully ordered. Order id "+data+"</p>").appendTo(".response-message");
            setTimeout(handleSuccess, 6000);
        }).fail(function( jqXHR) {
            $("<p>Error: "+jqXHR.status+"</p>").appendTo(".response-message");
            console.log( "Error: " + jqXHR.status);
        })
    });

    $(".btn-secondary").click(function(){
        $('.products-list').empty();
        $("#order-btn").off();
        $('.response-message').empty();
    });

    $(".close").click(function(){
        $('.products-list').empty();
        $("#order-btn").off();
        $('.response-message').empty();
    });

    $("#clear-btn").click(function(){
        handleSuccess();
    });
});

function getIdsFromBasket(){
    var products = JSON.parse(sessionStorage.getItem("products"));
    if(products){
        return products;
    }
    console.log("Error: session cache is empty!")
}

function buildListOfProducts(products) {
    var productListHTML = "<ol>";
    var totalPrice = 0;
    $.each(products, function (index, product) {
        productListHTML = productListHTML + '<li>#'+product.productId+' '+product.productName+' '+product.productPrice+'$</li>'
        totalPrice = totalPrice+product.productPrice;
    });
    return productListHTML + '<ol><h4>Total Price: '+totalPrice+'$</h4>';
}

function buildOrder(products) {
    var user = new Object();
    user.userName = $("#recipient-name").val();
    user.userEmail = $("#recipient-email").val();

    var order = new Object();
    order.user = user;
    order.products = products;
    return order;
}

function handleSuccess() {
    sessionStorage.clear();
    $(".btn-secondary").trigger('click');
    $('.products-list').empty();
    $('.response-message').empty();
    $("#order-btn").off();
}

