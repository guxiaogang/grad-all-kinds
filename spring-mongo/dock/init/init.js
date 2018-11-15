var newUsers = [
    {
        user: 'mongo',
        pwd: '123',
        roles: [
            {
                role: 'readWrite',
                db: 'product'
            }
        ]
    }
];

var currentUsers = db.getUsers();
if (currentUsers.length === newUsers.length) {
    quit();
}
db.dropAllUsers();

for (var i = 0, length = newUsers.length; i < length; ++i) {
    db.createUser(newUsers[i]);
}