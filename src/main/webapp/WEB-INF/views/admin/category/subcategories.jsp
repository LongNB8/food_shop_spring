<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content-header">
    <h1>
        Sub Category List of ${category.name}

    </h1>
    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/category/addsubcategory/${category.id}">add</a></li>

    </ol>
</section>



<section class="content">
    <div class="row">
        <div class="col-xs-12">

            <c:if test="${error != null}">
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4><i class="icon fa fa-ban"></i> Error!</h4>
                   ${error}
                </div>
            </c:if>


            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Hover Data Table</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-6"></div><div class="col-sm-6"></div></div><div class="row"><div class="col-sm-12"><table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
                        <thead>
                        <tr role="row">
                            <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending">Id</th>
                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending">Name</th>
                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending">Status</th>
                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Engine version: activate to sort column ascending">Action</th>

                        </thead>
                        <tbody>
                        <c:forEach var="c" items="${category.categories}">
                            <tr role="row" class="odd">
                                <td >${c.id}</td>
                                <td>${c.name}</td>
                                <td>${c.status ? 'Show' : 'Hide'}</td>
                                <td>
                                <a href="${pageContext.request.contextPath}/admin/category/subcategory/edit/${c.id}">Edit</a>
                                    |
                                    <a href="${pageContext.request.contextPath}/admin/category/subcategory/delete/${c.id}"
                                       onclick="return confirm('Are you delete')">Delete</a>

                                </td>


                            </tr>
                        </c:forEach>
                        </tbody>
                     
                    </table></div></div><div class="row"><div class="col-sm-5"><div class="dataTables_info" id="example2_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div></div><div class="col-sm-7"><div class="dataTables_paginate paging_simple_numbers" id="example2_paginate"><ul class="pagination"><li class="paginate_button previous disabled" id="example2_previous"><a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li><li class="paginate_button active"><a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0">1</a></li><li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0">2</a></li><li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0">3</a></li><li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0">4</a></li><li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0">5</a></li><li class="paginate_button "><a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0">6</a></li><li class="paginate_button next" id="example2_next"><a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li></ul></div></div></div></div>
                </div>
                <!-- /.box-body -->
            </div>

        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>