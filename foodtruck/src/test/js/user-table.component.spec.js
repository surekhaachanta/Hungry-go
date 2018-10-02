describe('userTable', function () {
    beforeEach(module('app'));

    describe('UserTableController', function () {

        it('should create a `users` model with 0 phones', inject(function ($componentController) {
            var ctrl = $componentController('userTable');

            expect(ctrl.users.length).toBe(0);
        }));

    });
});