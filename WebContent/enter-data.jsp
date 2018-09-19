<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<title>Create your CV!</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>$(document).ready(function(){
		$("#addStudy").click(function(){
			$("input[name=studyEndDate]").last().after('<br /><input class="modifiedWidth" maxlength="58" name="college" placeholder="College"><br /><input class="modifiedWidth" maxlength="58" name="fieldOfStudy" placeholder="Field of study"><br /><input class="modifiedWidth" name="studyStartDate" placeholder="Start date" type="date">&nbsp;<input class="modifiedWidth" name="studyEndDate" placeholder="End date" type="date">');
		});	
		$("#addJob").click(function(){
			$("input[name=jobEndDate]").last().after('<br /><input class="modifiedWidth" maxlength="58" name="company" placeholder="Name of company"><br /><input class="modifiedWidth" maxlength="58" name="post" placeholder="Name of post"><br /><input class="modifiedWidth" name="jobStartDate" placeholder="Start date" type="date">&nbsp;<input class="modifiedWidth" name="jobEndDate" placeholder="End date" type="date">');
		});
		$("#addLanguage").click(function(){
			$("#addLanguage").last().after('<br /><input class="modifiedWidth" maxlength="58" name="languageName" placeholder="Language">&nbsp;<input class="modifiedWidth" maxlength="58" name="languageLevel" placeholder="Level of advancement">');
		});	
		});	
	</script>
    <style>
    input.modifiedWidth{
        width: 14%;
    }
    </style>
</head>
<body style="margin:5%;">
	<form action="enter-data" method="post" enctype="multipart/form-data">
	    <div class="container">
	        <label>Personal data:</label><br />
	        <input class="modifiedWidth" maxlength="58" name="fullName" placeholder="Full name" required><br />
	        <input class="modifiedWidth" maxlength="58" name="birthdate" placeholder="Birthdate" required type="date"><br />
	        <input class="modifiedWidth" maxlength="58" name="city" placeholder="City" required><br />
	        <input class="modifiedWidth" maxlength="15" name="phoneNumber" placeholder="Phone number" required>
	        <hr>
	        <label>Picture <small>(JPG format)</small>:</label>
	        <input name="picture" type="file" required>
	        <hr>
	        <label>Education: </label><br />
	        <input class="modifiedWidth" maxlength="58" name="college" placeholder="College"><button id="addStudy" type="button">+</button><br />
	        <input class="modifiedWidth" maxlength="58" name="fieldOfStudy" placeholder="Field of study"><br />
	        <input class="modifiedWidth" name="studyStartDate" placeholder="Start date" type="date">&nbsp;<input class="modifiedWidth" name="studyEndDate" placeholder="End date" type="date">
	        <hr>
	        <label>Professional experience: </label><br />
	        <input class="modifiedWidth" maxlength="58" name="company" placeholder="Company name"><button id="addJob" type="button">+</button><br /> 
	        <input class="modifiedWidth" maxlength="58" name="post" placeholder="Name of post"><br />
	        <input class="modifiedWidth" name="jobStartDate" placeholder="Start date" type="date">&nbsp;<input class="modifiedWidth" name="jobEndDate" placeholder="End date" type="date">
	        <hr>
	        <label>Languages:</label><br />
	        <input class="modifiedWidth" maxlength="58" name="languageName" placeholder="Language">&nbsp;<input class="modifiedWidth" maxlength="58" name="languageLevel" placeholder="Level of advancement"><button id="addLanguage" type="button">+</button>
	        <hr>
	        <label>Skills: </label><br />
	        <textarea class="modifiedWidth" cols="50" maxlength="6000" name="skills" rows="4" placeholder="Skills"></textarea>
	        <hr>
	        <input type="submit" value="Submit">
	    </div>
	</form>
</body>

</html>
