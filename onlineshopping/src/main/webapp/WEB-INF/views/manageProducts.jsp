<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
    <!-- Error Messages -->
      <c:if test="${not empty message}">
      
      <div class="col-xs-12">
      
        <div class="alert alert-success alert-dismissible text-center">
          <span class="close" data-dismiss="alert">&times;</span>
             ${message}
        </div>
         
      </div>
      
      </c:if>
    
    </div>

    <div class="row">
        <div class="col-sm-offset-2 col-sm-8">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="text-center">Product Management</h3>
            </div>
            <div class=" panel-body">
                <sf:form class="form-horizontal" modelAttribute="product" method="POST" 
                      action="${contextRoot}/manage/products">
                    <div class="form-group">
                        <LABEL class="control-label col-sm-4" for="name">Name</LABEL>
                        <div class="col-sm-8">
                            <sf:input type="text" class="form-control" path="name" id="name"  placeholder="Product Name"/>
                            <sf:errors path="name" cssClass="help-block" element="em"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <LABEL class="control-label col-sm-4" for="brand">Brand</LABEL>
                        <div class="col-sm-8">
                            <sf:input type="text" class="form-control" id="brand" path="brand" placeholder="Brand Name"/>
                            <sf:errors path="brand" cssClass="help-block" element="em"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <LABEL class="control-label col-sm-4" for="description">Description</LABEL>
                        <div class="col-sm-8">
                            <sf:textarea class="form-control" id="description"  path="description" placeholder="Write a Description"/>
                            <sf:errors path="description" cssClass="help-block" element="em"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <LABEL class="control-label col-sm-4" for="unitPrice">Enter Unit Price </LABEL>
                        <div class="col-sm-8">
                            <sf:input type="number" class="form-control" id="unitPrice"  path="unitPrice" placeholder="Unit Price in Rupee(s)"/>
                            <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <LABEL class="control-label col-sm-4" for="quantity">Quantity Available </LABEL>
                        <div class="col-sm-8">
                            <sf:input type="number" class="form-control" id="quantity"  path="quantity" placeholder="Quantity Available"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="categoryId" class="control-label col-sm-4">Select Category</label>
                        <div class="col-sm-8">
                        <sf:select class="form-control" id="categoryId" path="categoryId"
                          items="${categories}"
                          itemLabel="name"
                          itemValue="id"
                         />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-8">
                            <button type="submit" class="btn btn-primary" value="Submit" >Submit</button>
                        </div>
                    </div>
                    <!-- Hidden Fields -->
                    <sf:hidden path="id"/>
                    <sf:hidden path="code"/>
                    <sf:hidden path="active"/>
                    <sf:hidden path="purchases"/>
                    <sf:hidden path="supplierId"/>
                    <sf:hidden path="views"/>
                </sf:form>
            </div>
        </div>
    </div>
    </div>
</div>
