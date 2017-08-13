<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Hello Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
              <div class="col-md-3"></div>
              <div class="col-md-6">
                <h1>News Bleep!</h1>
                <div class="panel panel-primary">
                  <div class="panel-heading">
                    <h3 class="panel-title">Censored Result</h3>
                  </div>
                  <div class="panel-body" id="censored-result">
                    <%= request.getAttribute("censored-result") %>
                  </div>
                </div>

                <form action="censor" method="post">
                  <div class="form-group">
                    <label for="headline">Headline</label>
                    <input type="text" class="form-control" name="headline" id="headline" placeholder="Headline">
                  </div>
                  <div class="form-group">
                    <label for="censor-word">Censored word</label>
                    <input type="text" class="form-control" name="censor-word" id="censor-word" placeholder="Censored word">
                  </div>
                  <button type="submit" id="submit" class="btn btn-default">Submit</button>
                </form>

              </div>
              <div class="col-md-3"></div>
            </div>
        </div>
    </body>
</html>