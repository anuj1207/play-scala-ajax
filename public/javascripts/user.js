$(document).ready(function(){

    $('#signin').on("click",function(){
        console.log($('#username').val())
        console.log("clicked")
        jsRoutes.controllers.SignInController.signInForm($('#username').val(),$('#password').val()).ajax({
            success: function(data){
              $('#body').html(data);

            },
            error: function(){
            $('#body').html("hello");
            alert("fail")
          }

        })
    })

    $('#signUp').on("click",function(){
        /*alert("clicked")*/
            console.log($('#name').val())
            console.log("clicked")
            jsRoutes.controllers.SignUpController.signUp($('#name').val(),$('#username').val(),
                            $('#password').val(),$('#pwdCheck').val(),$('#gender').val(),$('#age').val()).ajax({
                        success: function(data){
                          $('#body').html(data);

                        },
                        error: function(){
                        $('#body').html("hello");
                        alert("fail")
                      }
            })
    })

    $('#logout').on("click",function(){
        console.log("clicked")
        jsRoutes.controllers.HomeController.index().ajax({
            success: function(data){
              $('#body').html(data);

            },
            error: function(){
            $('#body').html("hello");
            alert("fail")
          }

        })
    })

});