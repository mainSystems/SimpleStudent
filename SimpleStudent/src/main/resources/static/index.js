angular.module('appStudies', ['ngStorage'])
    .controller('indexController', function($scope, $http, $localStorage) {
    const contextPath='http://localhost:8180/app/api/v1/studies';

    $scope.mapStudentMark = new Map();

    $scope.loadStudents = function() {
        $http.get(contextPath + '/mainPage')
        .then(function (response){
            console.log(response);
            $scope.studentList = response.data;
        });
    };

    $scope.newCart = function() {
        $http.get(contextPath + '/new_cart')
        .then(function (response){
            $scope.loadStudents();
        });
    };

    $scope.changeStudentMark = function(id, mark) {
        $http({
            url: contextPath + '/studentMark',
            method: 'POST',
            params: {
                id: id,
                mark: mark
            }
        }).then(function(response) {
            console.log(response);
            $scope.loadStudents();
        });
    }

    $scope.purgeProduct = function(productId) {
            $http({
                url: contextPath + '/products',
                method: 'DELETE',
                params: {
                    productId: productId
                }
            }).then(function(response) {
                $scope.loadStudents();
            });
        }

    $scope.getStudentMark = function(id) {
            $http({
                url: contextPath + '/studentMark',
                method: 'GET',
                params: {
                    id: id
                }
            }).then(function(response) {
                $scope.studentMark = response.data;
                $scope.mapStudentMark.set(id,$scope.studentMark);
//                console.log(id);
                console.log($scope.mapStudentMark);
            });
        }

    $scope.loadStudents();
});