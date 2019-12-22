$(function(){
	populateRatingData();
	$("#ratingForm").on('submit',function(event){
		event.preventDefault();
		submitRatingData();
	});
	$("#submitButton").click(function(event){
		event.preventDefault();
		populateAverageRatingData();
		
	});
	
});

function submitRatingData(){
	var ratingData=JSON.stringify({
	userid:$("#userid").val(),
	username:$("#username").val(),
	movieId:$("#movieId").val(),
	movieName:$("#movieName").val(),
	rating:$("#rating").val()
	});
	$.ajax({
        url: '/saveMovieRating',
        dataType: 'json',
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: ratingData,
        cache: false,
        timeout: 500000,
        success: function(res){
        	console.log(res);
        	populateRatingData();
        	clearForm();
        },
        error: function(res){
        	console.log(res);
        }
    });
	
}

function populateRatingData(){
	$.ajax({
        url: '/getAllRating',
        dataType: 'json',
        type: "GET",
        contentType: "application/json; charset=utf-8",
        cache: false,
        timeout: 500000,
        success: function(res){
        	console.log(res);
        	var html='';
        	res.forEach(data=>{
        		html=html+
            		`<tr>
            		<td>${data.id}</td>
            		<td>${data.userid}</td>
            		<td>${data.username}</td>
            		<td>${data.movieId}</td>
            		<td>${data.movieName}</td>
            		<td>${data.rating}</td>
            		</tr>`;
        	})
        	$("#ratingData").html(html);
        },
        error: function(res){
        	console.log(res);
        }
    });
}
function clearForm(){
	$("#userid").val("");
	$("#username").val("");
	$("#movieId").val("");
	$("#movieName").val("");
	$("#rating").val("");
}

function populateAverageRatingData(){
	var movieId=$("#searchMovieId").val();
	$.ajax({
        url: '/getAvgRating/'+movieId,
        dataType: 'json',
        type: "GET",
        contentType: "application/json; charset=utf-8",
        cache: false,
        timeout: 500000,
        success: function(res){
        	console.log(res);
        	var html='';
        		html=html+
            		`<tr>
            		<td>${res.movieId}</td>
            		<td>${res.movieName}</td>
            		<td>${res.rating}</td>
            		</tr>`;
        	$("#avgRating").html(html);
        	$("#searchMovieId").val("");
        	
        },
        error: function(res){
        	console.log(res);
        }
    });
}
