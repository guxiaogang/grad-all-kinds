// mongo-shard-01
sh.addShard( "mongo-shard-01/mongo-shard-01a:27018")
sh.addShard( "mongo-shard-01/mongo-shard-01b:27018")
sh.addShard( "mongo-shard-01/mongo-shard-01c:27018")

// mongo-shard-02
sh.addShard( "mongo-shard-02/mongo-shard-02a:27019")
sh.addShard( "mongo-shard-02/mongo-shard-02b:27019")
sh.addShard( "mongo-shard-02/mongo-shard-02c:27019")