package ls.yylx.customviewdsl.fragment.adapter_backup


//class CustomViewXmlFragment : Fragment() {
//    val vm by lazy {
//        ViewModelProviders.of(requireActivity())[MainViewModel::class.java]
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        var view: View? = null
//        val time = measureTimeMillis {
////            runBlocking {
//                view = inflater.inflate(R.layout.fragment_recycleview, container, false)
//
////                repeat(10000) {
////                    println(it)
//                    view!!.find<RecyclerView>(R.id.rv).run {
//                        adapter = SpeciesCustomItemRvAdapter(vm.all)
//                        layoutManager = LinearLayoutManager(requireContext())
//                    }
////                }
////            }
//        }
//
//        println("XmlFragment     $time ms")
//
//        return view
//    }
//
//
//}
