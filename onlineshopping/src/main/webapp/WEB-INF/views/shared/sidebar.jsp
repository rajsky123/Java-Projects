<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p class="lead">Shop Name</p>
                <div class="list-group">
                
                <c:forEach items="${categories}" var="category">
                    <a href="#" class="list-group-item">${category.name}</a>
                   </c:forEach>
                   
                </div>