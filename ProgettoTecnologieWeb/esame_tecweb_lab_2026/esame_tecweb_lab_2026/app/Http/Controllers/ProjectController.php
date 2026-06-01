<?php

namespace App\Http\Controllers;

use App\Models\Project;
use App\Models\Department;
use Illuminate\Http\Request;
use Log;

class ProjectController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $departments = Department::select('id', 'name')->get();

        $projects = Project::with('department')->paginate(10);

        return view('projects.index', compact('projects', 'departments'));
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        $departments = Department::select('id', 'name')->get();

        return view('projects.create', compact('departments'));
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        
        $request->validate([
            // TASK 4 — Definisci le regole di validazione per i tre campi:
            'name'          => 'required|string|min:3|max:255',
            'site_name'     => 'nullable|string|min:2|max:255',
            'department_id' => 'required|exists:departments,id',
        ]);

        $input = $request->all();

        // TASK 13 Completa l'inserimento via AJAX
        if ($request->ajax()) {
            try {
                $project = Project::create($input);
                
                $project->load('department');

                // CORREZIONE: Inseriamo 'name' e 'department_name' espliciti per il frontend del prof
                return response()->json([
                    "success" => true,
                    "message" => "Project creato con successo!",
                    "data" => [
                        "id"              => $project->id,
                        "name"            => $project->name, 
                        "site_name"       => $project->site_name,
                        "department_id"   => $project->department_id,
                        "department"      => $project->department ? $project->department->name : null,
                        "department_name" => $project->department ? $project->department->name : null,
                        "created_at"      => $project->created_at->format('d/m/Y'),
                        "updated_at"      => $project->updated_at->format('d/m/Y')
                    ]
                ], 200);

            } catch (\Exception $e) {
                return response()->json([
                    "success" => false,
                    "message" => "Errore durante il salvataggio dei dati via AJAX."
                ], 500);
            }
        }

        try {
            // TASK 5 — Crea un nuovo Project nel database usando i dati di $input.
            Project::create($input);

            return redirect(route('projects.index'));

        } catch (\Exception $e) {

            return back()->with('error', 'Errore durante il salvataggio dei dati.');
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(Project $project)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Project $project)
    {
        $departments = Department::select('id', 'name')->get();

        return view('projects.edit', compact('departments', 'project'));
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Project $project)
    {
        
        $request->validate([
            // TASK 6 — Stesse regole di validazione del metodo store():
            'name'          => 'required|string|min:3|max:255',
            'site_name'     => 'nullable|string|min:2|max:255',
            'department_id' => 'required|exists:departments,id',
        ]);

        $input = $request->all();

        try {
            // TASK 6 (cont.) — Aggiorna il progetto $project con i dati di $input.
            $project->update($input);

            return redirect(route('projects.index'));

        } catch (\Exception $e) {

            return back()->with('error', 'Errore durante il salvataggio dei dati.');
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Project $project)
    {
        // TASK 7 — Elimina il progetto $project dal database.
        $project->delete();

        if (request()->ajax()) {
            return response()->json(['message' => 'Project eliminato con successo.']);
        }

        return redirect(route('projects.index'));
    }
}