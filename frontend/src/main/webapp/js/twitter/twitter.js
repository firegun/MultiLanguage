var signinTwitter = function(event){
    console.log("signin twitter");

    $.ajax({
        type: "POST",
        url: "http://127.0.0.1:8080/frontend/rest/twitter/oauth"
    }).done(function(response) {
        console.log(response);
        window.location.replace(response);
    });


};