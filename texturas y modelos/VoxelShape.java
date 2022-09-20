Stream.of(
Block.box(6, 2, 6, 10, 3, 10),
Block.box(3, 1, 3, 13, 2, 13),
Block.box(2, 0, 2, 14, 1, 14)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();