$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8081/products"
    }).then(function(data) {
        handleResponce(data);
        $( ".btn-bskt" ).click(function(e) {
            e.preventDefault();
            addProductToSessionStorage(this.closest(".card").id);
        });
    });

    $("#buy-btn").click(function(){
        $.getScript("../../../../assets/js/order.js");
    });
});

function handleResponce(products) {
    var productBarHTML = '';
    $.each(products, function (index, product) {
        index++;
        if (index%4 == 1){
            productBarHTML = productBarHTML+'<div class="products-row" style="display: inline-flex;">' +
                    constractCardTag(product);
        }else if (index%4 == 0){
            productBarHTML = productBarHTML+constractCardTag(product) + '</div>';
        }else {
            productBarHTML = productBarHTML+constractCardTag(product);
        }
    });
    if (products.length%4 != 0){
        productBarHTML = productBarHTML+'</div>';
    }
    $(productBarHTML).appendTo(".products-area");
}

function constractCardTag(product) {
    return '<div class="card" id="'+product.productId+'" style="width: 25%;">' +
    '<img class="card-img-top" src="../../img/shop5537.jpg" alt="Card image cap">' +
    '<div class="card-body">' +
    '<div style="display: inline-flex"><h4 class="card-title">'+product.productName+'</h4>' +
    '<p class="card-text" style="align-self: center;margin-left: 80px;">Product Id: '+product.productId+'</p></div>' +
    '<p class="card-text">Product Price: '+product.productPrice+' $</p>' +
    '<a href="#" class="btn btn-primary btn-bskt">Add to basket</a></div></div>';
}

function addProductToSessionStorage(productId) {
    var products = JSON.parse(sessionStorage.getItem("products"));
    if(products){
        products.push(productId);
    }else {
        products = [];
        products.push(productId);
    }
    sessionStorage.setItem("products", JSON.stringify(products));
}

