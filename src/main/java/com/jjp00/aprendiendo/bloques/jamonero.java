package com.jjp00.aprendiendo.bloques;


import com.jjp00.aprendiendo.registro.RegItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;




public class jamonero extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE = box(0,0,5,16,11,11);
    private static final VoxelShape SHAPE2 = box(5,0,0,11,11,16);

    private static final IntegerProperty USES = IntegerProperty.create("uses", 0,16);

    public jamonero() {
        super(BlockBehaviour.Properties.of(Material.WOOD)
                .sound(SoundType.WOOD).strength(1F).sound(SoundType.WOOD).explosionResistance(2));
        this.registerDefaultState(this.stateDefinition.any().setValue(USES, 0));
    }

    @Override
    public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) {
        int i = p_60503_.getValue(USES);
        Item jamon = RegItem.jamon.get();
        ItemStack itemStack = p_60506_.getItemInHand(p_60507_);
        if (i == 0 && !p_60504_.isClientSide) { //comprobamos que tenemos jamon en mano y
                if (itemStack.is(jamon))  {                                // que el jamonero este vacio
                  addJamon(p_60503_,p_60504_,p_60505_,itemStack);
              }
            return InteractionResult.sidedSuccess(p_60504_.isClientSide);
        } else if (i > 0) { //i mas que 0 por lo tanto tiene un jamon encima
            if (itemStack.is(Items.IRON_SWORD)) {
                cortarJamon(p_60503_,p_60504_,p_60505_);
            }
            return InteractionResult.sidedSuccess(p_60504_.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }


    public static BlockState addJamon(BlockState bloque, Level level, BlockPos pos, ItemStack stack) {
        BlockState blockstate = bloque;
        if (stack.is(RegItem.jamon.get()))  {                                // que el jamonero este vacio
            blockstate = bloque.setValue(USES, 16);
            level.setBlock(pos,blockstate,3);
            stack.shrink(1);
        }
        return blockstate;
    }

    public static BlockState cortarJamon(BlockState bloque, Level level, BlockPos pos) {
        if (!level.isClientSide) {
            double d0 = (double)(level.random.nextFloat() * 0.5F) + (double)0.15F;
            double d1 = (double)(level.random.nextFloat() * 0.11F) + (double)0.060000002F + 0.6D;
            double d2 = (double)(level.random.nextFloat() * 0.5F) + (double)0.15F;
            ItemEntity itementity = new ItemEntity(level, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, new ItemStack(RegItem.jamonFood.get()));
            itementity.setDefaultPickUpDelay();
            level.addFreshEntity(itementity);
        }
        int usos = bloque.getValue(USES);
        usos = usos - 1;
        BlockState blockState = bloque;
        blockState = bloque.setValue(USES, usos);
        level.setBlock(pos,blockState,3);
        return blockState;
    }

    //hitbox
    private VoxelShape getVoxelShape(BlockState state) {
        Direction direction = state.getValue(FACING);
        switch(direction) {
            case SOUTH:
            case NORTH:
                return SHAPE2;
            default:
                return SHAPE;
        }
    }
    //direccion
    @Override
    public VoxelShape getShape(BlockState p_151964_, BlockGetter p_151965_, BlockPos p_151966_, CollisionContext p_151967_) {
        return getVoxelShape(p_151964_);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
        return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState p_48719_, Mirror p_48720_) {
        return p_48719_.rotate(p_48720_.getRotation(p_48719_.getValue(FACING)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
        p_48725_.add(FACING, USES);
    }
}
