define(
['jquery'],
function($){

    var signinTwitter = function(event){
        $.ajax({
            type: "POST",
            url: "http://127.0.0.1:8080/frontend/rest/twitter/oauth"
        }).done(function(response) {
            window.location.replace(response);
        });
    };
    return signinTwitter;
});
